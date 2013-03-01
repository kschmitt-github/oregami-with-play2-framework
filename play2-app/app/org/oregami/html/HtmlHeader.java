package org.oregami.html;

public class HtmlHeader {
	
	private static final String DEFAULT_HTML_TITLE = "Oregami.org (noTitleGiven)";
	
	private String title;

	public String getTitle() {
		return title;
	}

	public HtmlHeader title(String title) {
		this.title = title;
		return this;
	}
	
}
