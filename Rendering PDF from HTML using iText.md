#pdf

Using HTML
```java
StringBuilder htmlString = new StringBuilder();
            htmlString.append("\n" +
                    "<table border=\"1\">\n" +
                    "  <tr>\n" +
                    "    <th>Company</th>\n" +
                    "    <th>Contact</th>\n" +
                    "    <th>Country</th>\n" +
                    "  </tr>\n" +
                    "</table>");

ArrayList elements = HTMLWorker.parseToList(new StringReader(htmlString.toString()), null);
Paragraph htmlPara = new Paragraph();
for (Object ele : elements){
	htmlPara.add((com.lowagie.text.Element)ele);
}
document.add(htmlPara);
```