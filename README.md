# GroupingProject
This code finds "groups" of numbers, letters, or symbols that exist in an Excel spreadsheet. 
Two values are grouped if they are 1) the same, and 2) one exists directly above, below, or to the side of the other. 
This code reads in an Excel spreadsheet and then outputs another Excel file showing all groups, the values of the
numbers in those groups, and the sizes of the groups. A sample input Excel spreadsheet has been provided.

Currently, the code will only accept files where all rows and columns that exist are completely filled in (no blanks or 
partially filled rows/columns), attempts will be made to account for blank values for future updates.

It is a managable task to adapt this code to handle arrays rather than spreadhseets (indeed, that version of this 
problem appears, occasionally, as part of an assessment of a programming job application) although that 
presents challenges with visualization.

The Java files were run in Eclipse and require the installation of the 
Apache POI libraries in order to work with Excel spreadsheets.

Eclipse can be downloaded here: https://eclipse.org/

The Apache POI libraries are available for free and can be found here: https://poi.apache.org/
