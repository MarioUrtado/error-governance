# error-governance
Governance error

**__Parameters__**

**---mapping.input** URL de documento Excel "GOVSOA Returns Code 1.3.xlsx". Default=https://tdentel.atlassian.net/wiki/download/attachments/565838019/GOVSOA%20Returns%20Codes%20v1.3.xlsx?api=v2

**--canonical.input** URL de documento Excel "GOVSOA Returns Code 1.3.xlsx". Default=https://tdentel.atlassian.net/wiki/download/attachments/565838019/GOVSOA%20Returns%20Codes%20v1.3.xlsx?api=v2

**--header.input** URL de documento Excel "GOVSOA Returns Code 1.3.xlsx". Default=https://tdentel.atlassian.net/wiki/download/attachments/565838019/Master%20Headers%20Codes%20eUSB.xlsx?api=v2

**--canonical.input.sheet.name** Nombre de pestaña donde se encuentra definidos los errores canonicos. Default=ESB_CANONICAL_ERROR

**--mapping.input.sheet.name** Nombre de pestaña donde se encuentra definidos las traducciones de errores. Default=ESB_ERROR_MAPPING

**--canonical.output** Directorio donde se generara los script de errores canonicos

**--mapping.output** Directorio donde se generara los script de traduccion de errores

**--reference.data.output** Directorio donde se generara los sript de reference data

**--credentials.confluence.username** Usuario de acceso a confluence

**--credentials.confluence.password** Password de usuario de acceso a confluence


**__Build__**

**gradle bootJar && build/lib**


**mvn package && build/lib**

**Example with parameter required**

$- java -jar entity-governance-0.1.0.jar --credentials.confluence.password=XXXXXXX --credentials.confluence.username=XXXXXXX --mapping.output=D:\TEMP --canonical.output=D:\TEMP
