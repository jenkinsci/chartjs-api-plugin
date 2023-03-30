# chartjs-api plugin

This plugin itself as it is, does nothing. It is jsut provider for awesome [chart.js](https://www.chartjs.org/docs/latest/) library.
It allows you to easily use js-rendered charts to the **job** page or to the **view** page.

See examples in known plugin consumers for:
 * [jenkins-report-generic-chart-column](https://github.com/judovana/jenkins-report-generic-chart-column#view-summary)
 * [jenkins-report-jck](https://github.com/judovana/jenkins-report-jtreg#project-details)
 * [jenkins-report-rpms](https://github.com/judovana/jenkins-report-diff#project)

# How to embed
 This api is simply adding the chart.js library  to the view and/or project page see  [header](src/main/resources/io/jenkins/plugins/chartjs/Chartjs/header.jelly). Them, eg. in your `column.jelly` or `floatingBox.jelly` you can use powers of chart.js firectly. See appropriate files in above projects. See https://www.chartjs.org/docs/latest/ and you should be ok to script it all.

