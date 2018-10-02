SET ECHO ON
SET DEFINE OFF
SET SERVEROUTPUT ON
WHENEVER SQLERROR CONTINUE ROLLBACK
DECLARE
    V_ID NUMBER;
BEGIN
<#list mappings as mapping>
	    BEGIN
             SELECT count(*) INTO ELEMENT_CONT
            FROM ESB_CANONICAL_ERROR
            WHERE CODE ='${mapping.code}' and TYPE_ID = ( SELECT ID FROM ESB_CANONICAL_ERROR_TYPE WHERE TYPE = '${mapping.type}');
            IF ELEMENT_CONT = 0 THEN
                INSERT INTO ESB_CANONICAL_ERROR(ID,CODE,TYPE_ID,DESCRIPTION,PRIORITY,RCD_STATUS) values ( ESB_CANONICAL_ERROR_SEQ.NEXTVAL,'${mapping.code}',( SELECT ID FROM ESB_CANONICAL_ERROR_TYPE WHERE TYPE = '${mapping.type}'),'${mapping.description}','1','1');
            ELSE
              DBMS_OUTPUT.Put_line ('ESB_CANONICAL_ERROR code = ${mapping.code} - ya existe');
            END IF;
        END;
</#list>
END;