
Pre-Requisities to run the project
1. Java 1.8
2. Maven
3. JUnit
5. TestNG
4. Eclipse ( To import the project and easy to run)

This is a Sample project to check the Change Password with respect to System Password.

org.apache.commons.lang3.StringUtils class is used to check the password similarity

getPasswordSimilarity(String newPassword) will take new password as input parameter and checks with the System password for 
the no of characters not matched . For Example
StringUtils.getLevenshteinDistance("abc","abde") -- it gives 2 --> total chars=4 and matched one to one =2 . So 4-2=2
StringUtils.getLevenshteinDistance("abc","abccde") -- it gives 3 --> total chars=6 and  matched one to one =3 . So 6-3=3

Key Highlights
---------------- 
1. Added Dashboard using some open source code
2. Implemeted both TestNG and Junit test cases
3. Added few Test Cases using TestNG dataprovider
4. Demonstrated few test cases and results will be logged into the Dashboard
5. Implemeted basic logger

Note: Please look into the attached screen shot DashBoardResults.png
