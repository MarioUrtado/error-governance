SET ECHO ON
SET DEFINE OFF
SET SERVEROUTPUT ON
WHENEVER SQLERROR CONTINUE ROLLBACK
DECLARE
    V_ID NUMBER;
BEGIN

	<#list entities as entity>
        BEGIN
            SELECT ID INTO V_ID
            FROM ESB_CDM_ENTITY
            WHERE NAME = ${entity};
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
            BEGIN
                INSERT INTO ESB_CDM_ENTITY (ID, NAME, VERSION, RCD_STATUS)
                VALUES (ESB_CDM_ENTITY_SEQ.NEXTVAL, '${entity}', '1' '1');
            END;
        END;
	</#list>
END;