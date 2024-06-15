Automation testing task #1 (UI)

Resource: xm.com

Tools: Java AND Selenium

Task: Automate next use case to run in three different browser’s screen resolution:
1) Maximum (supported by your display)
2) 1024 x 768
3) 800 x 600
Use Case:
1. Open Home page (make any check here if needed).
2. Click the &lt;Research and Education&gt; link located at the top menu (make any check
here if needed).
3. Click &lt;Economic Calendar&gt; link in the opened menu (make any check here if
needed).
4. Select &lt;Today&gt; on Slider and check that the date is correct.
5. Select &lt;Tomorrow&gt; on Slider and check that the date is correct.
6. Select &lt;Next Week&gt; on Slider and check that the date is correct.
7. Click &lt;Educational Videos&gt; link under &lt;Research and Education&gt;
8. Click the Lesson 1.1 “Introduction to the Financial Markets.”
9. Educational video should play for a minimum of 5 seconds

HOW TO RUN TESTS
1. In terminal run command 'mvn test -DsuiteXmlFile="testng.xml"'
2. To view the test report, navigate to the following directory: target/surefire-reports/html/ and open the file index.html in a browser of your choice