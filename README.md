# chartjs-api plugin

This plugin does nothing by its own, but serves as provider of awesome [chart.js](https://www.chartjs.org/docs/latest/) library, which can then be reused in other.
It allows you to easily use js-rendered charts to the **job** page or to the **view** page.

See examples of known plugin consumers for:
 * [report-generic-chart-column-plugin](https://github.com/jenkinsci/report-generic-chart-column-plugin#project-summary)
 * [report-diff-plugin](https://github.com/jenkinsci/report-diff-plugin/#project)
 * [jenkins-report-jck](https://github.com/judovana/jenkins-report-jtreg#project-details)

# How to embed
 This api is simply adding the chart.js library to the view and/or project page see [header](src/main/resources/io/jenkins/plugins/chartjs/Chartjs/header.jelly). You have to first require it in your `pom.xml`:
 ```xml
<dependency>
  <groupId>io.jenkins.plugins</groupId>
  <artifactId>chartjs-api</artifactId>
  <version>${chartjs.version}</version>
</dependency>
```
And then, e.g., in your `column.jelly` or `floatingBox.jelly` you can use powers of chart.js directly. See appropriate files in the above projects for examples. See https://www.chartjs.org/docs/latest/, and you should be ok to script it in without issues.

