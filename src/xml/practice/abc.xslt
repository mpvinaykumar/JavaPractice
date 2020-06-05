<?xml version="1.0"?>
<xsl:stylesheet xmlns="http://www.w3.org/1999/xhtml"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" />
		</xsl:copy>
	</xsl:template>
	<xsl:template match="CD/NAME">
		<CD-NAME>
			<xsl:apply-templates select="@*|node()" />
		</CD-NAME>
	</xsl:template>
	<xsl:template match="CATALOG/NAME">
		<CATALOG-NAME>
			<xsl:apply-templates select="@*|node()" />
		</CATALOG-NAME>
	</xsl:template>
</xsl:stylesheet>