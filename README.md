
Pre-Requisities to run the project
1. Java 1.7
2. Maven
3. JUnit
4. Eclipse ( To import the project and easy to run)

This is a Sample project to check the Change Password with respect to System Password.

org.apache.commons.lang3.StringUtils class is used to check the password similarity

getPasswordSimilarity(String newPassword) will take new password as input parameter and checks with the System password for 
the no of characters not matched . For Example
StringUtils.getLevenshteinDistance("abc","abde") -- it gives 2 --> total chars=4 and matched one to one =2 . So 4-2=2
StringUtils.getLevenshteinDistance("abc","abccde") -- it gives 3 --> total chars=6 and  matched one to one =3 . So 6-3=3

