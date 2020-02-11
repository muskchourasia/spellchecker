# spellchecker


 
Statement:
Create a graph containing n nodes.Use the graph to check the validity of the sentence entered by the user. 
Introduction:
In this Assignment, the goal is to  implemented a program to generate a graph containing words and using graph traversal check for validity of the words in the sentence given by the user .And the nodes must be such that when combined with a suffix it forms a new word(for example :- one node has “box” and its children can have “ed” and “es” giving rise to two new words boxed and boxes). It can also be used as a spell checker for the words that are in the graph.
Implementation:
In this program, a graph is formed using a set of words in the manner specified by the program. Once the graph is constructed the user is can enter either a word or a set of words to be searched for in the graph. Dfs traversal is done on the graph. All the nodes are connected to a root node. If the length of word is less than or equal to three then the dfs traversal is done on the root node, if the entered string is found it returns valid sentence as output otherwise the string is marked as invalid. If the length of string is greater than three then the string is divided into two parts, first containing the first three characters of the string and second part containing the rest of the string. If the first part of string is found in the graph then dfs traversal is done on the nodes containing the string and the second part is searched for .If it is not found then the string is marked as invalid. If the entire sentence given as output does not contain an invalid word the program gives output as valid sentence otherwise it displays a list of all invalid words.









Output Generated:

 

