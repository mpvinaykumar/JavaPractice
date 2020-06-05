<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/ | @* | node()">
		<xsl:copy>
			<xsl:apply-templates select="@* | node()" />
		</xsl:copy>
	</xsl:template>

	<xsl:template match="/">
		<HTML>
			<BODY>
			<!-- this is a comment -->
				<xsl:comment>
					insert top news story
				</xsl:comment>
				
				<P>
					<xsl:value-of select="//story1" />
				</P>
			</BODY>
		</HTML>
	</xsl:template>

</xsl:stylesheet>