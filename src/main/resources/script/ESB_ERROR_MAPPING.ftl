SET ECHO ON
SET DEFINE OFF
SET SERVEROUTPUT ON
WHENEVER SQLERROR CONTINUE ROLLBACK
DECLARE
    V_ID NUMBER;
    ELEMENT_CONT NUMBER;
BEGIN

<#list mappings as mapping>
	    BEGIN
            BEGIN
                SELECT ID INTO V_ID FROM ESB_ERROR_MAPPING WHERE ERROR_SOURCE = (SELECT ID FROM ESB_SYSTEM WHERE CODE ${mapping.conditionalSystem}) AND MODULE ${mapping.conditionalModule} and SUB_MODULE ${mapping.conditionalSubModule} AND RAW_CODE ${mapping.conditionalRawCode};
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                BEGIN
                    INSERT INTO ESB_ERROR_MAPPING (ID, ERROR_SOURCE, MODULE, SUB_MODULE, RAW_CODE, RAW_DESCRIPTION, CAN_ERR_ID, STATUS_ID, RCD_STATUS)
                    VALUES (ESB_ERROR_MAPPING_SEQ.NEXTVAL,
                        (SELECT ID FROM ESB_SYSTEM WHERE CODE ${mapping.conditionalSystem}),
                        '${mapping.module}',
                        '${mapping.subModule}',
                        '${mapping.rawCode}',
                        '${mapping.rawDescription}',
                        (SELECT ID FROM ESB_CANONICAL_ERROR WHERE CODE = '${mapping.canonicalCode}' AND TYPE_ID = (SELECT ID FROM ESB_CANONICAL_ERROR_TYPE WHERE TYPE = '${mapping.canonicalType}')),
                        (SELECT ID FROM ESB_ERROR_STATUS_TYPE WHERE NAME = '${mapping.status}'),
                        '1') RETURNING ID INTO V_ID;
                END;

            END;
            BEGIN
                SELECT ERROR_MAPPING_ID INTO V_ID FROM ESB_ERROR_HTTP_MAPPING WHERE ERROR_MAPPING_ID = V_ID;
                EXCEPTION
                WHEN NO_DATA_FOUND THEN
                BEGIN
                    INSERT INTO ESB_ERROR_HTTP_MAPPING(ERROR_MAPPING_ID, HTTP_STATUS_ID)
                    VALUES (V_ID, (SELECT ID FROM ESB_HtTP_STATUS WHERE CODE = '${mapping.httpCode}' ));
                END;
            END;
            EXCEPTION
                WHEN OTHERS THEN
                BEGIN
                    DBMS_OUTPUT.PUT_LINE( SQLERRM || ' - ${mapping.errorMessage}.'  );
                    RAISE;
                END;
         END;
	</#list>


END;