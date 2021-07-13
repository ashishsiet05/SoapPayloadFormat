<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output omit-xml-declaration="yes" method="xml"></xsl:output>
<xsl:param name="AssiginID"/>
<xsl:template match="/">
            <urn:New_GetList_Operation_1 xmlns:urn="urn:IG:HPDHelpDeskQueryList">
                        <urn:Qualification>'Incident Number'="<xsl:value-of select="$AssiginID"/>"</urn:Qualification>
                         <urn:startRecord></urn:startRecord>
                    <urn:maxLimit></urn:maxLimit>
               </urn:New_GetList_Operation_1>
      </xsl:template>
</xsl:stylesheet>