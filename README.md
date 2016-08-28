<snippet>
  <content><![CDATA[
# ${1:KWIC (Key Word in Context)}

The Key Word in Context (KWIC) index system is a text processor that reads a string of text and circularly shifts the words in the sentence or phrase. Along this circular shifting process, strings with a keyword as the starting word will be recorded and appended into a collection of texts. This collection of texts is then sorted out alphabetically and is generated out as the output of the system. The KWIC is able to take in multiple lines of texts and collect all the shifted lines into a single output all together.

In this assignment, we have chosen two architectural designs, namely Implicit Invocation and Pipes and Filters, as our approach to build the KWIC application. As the application is compiled into a single launch method, user will be prompted to select one of the two architectures to run the application in the beginning. The application takes in two text files as input, the lines of texts to be processed and a list of common words to ignore respectively. When it runs, the application will generate the outputs into the output file specified as the application. More information and instructions of the application usage will be mentioned below and can also be found in the readme in the git resource.

## Usage

1. Download the .zip file from our GitHub repository
2. Extract the zip file
3. Copy and paste your input and ignore files into the extracted folder (make sure the input and ignore files are in the same directory as the KWIC.jar file)
4. In cmd(windows) or terminal(linux), change directory into the extracted
5. Run the following command "java -jar KWIC.jar"
6. Input the input and ignore file names, and the desired output file name
7. Choose the architechtural design (1 for Implicit Invocation, 2 for Pipes and Filters)
8. Observe output :)

## Credits

Donald Shum (A0121823R)
Lau Wen Hao (A0121528M)

]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>