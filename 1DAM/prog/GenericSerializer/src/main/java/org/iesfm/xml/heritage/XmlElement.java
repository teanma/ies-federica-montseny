package org.iesfm.xml.heritage;

import java.util.Objects;

public abstract class XmlElement {

    private String tagName;

    public XmlElement(String tagName) {
        this.tagName = tagName;
    }

    public abstract String asString();

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlElement that = (XmlElement) o;
        return Objects.equals(tagName, that.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagName);
    }

    @Override
    public String toString() {
        return "XmlElement{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
