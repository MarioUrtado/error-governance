SET ECHO ON
SET DEFINE OFF
SET SERVEROUTPUT ON
WHENEVER SQLERROR CONTINUE ROLLBACK
DECLARE
    V_ID NUMBER;
BEGIN

<#list mappings as mapping>
        BEGIN
            SELECT ID INTO V_ID
            FROM ESB_CDM_FIELD
            WHERE NAME = '${mapping.field}' AND ENTITY_ID = (SELECT ID FROM ESB_CDM_ENTITY WHERE NAME = '${mapping.entity}');
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
            BEGIN
                INSERT INTO ESB_CDM_FIELD (ID, NAME, ENTITY_ID, RCD_STATUS)
                VALUES (ESB_CDM_FIELD_SEQ.NEXTVAL, '${mapping.field}', (SELECT ID FROM ESB_CDM_ENTITY WHERE NAME = '${mapping.entity}'), '1');
            END;
        END;
	</#list>
END;