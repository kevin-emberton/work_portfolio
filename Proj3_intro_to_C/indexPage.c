/* File: indexPage.c */
/* Author: Britton Wolfe */
/* Date: September 3rd, 2010 */

/* This program indexes a web page, printing out the counts of words on that page */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "indexPage.h"

/* TODO: define the functions corresponding to the above prototypes */

/* TODO: change this return type */


struct TrieNode * indexPage(const char* url)
{
  const int bufferSize = 300000;

  char pString[bufferSize];
  char word[bufferSize];
  word[0] = '\0';

  if(getText(url, pString, bufferSize)){

    int pageIndex = 0;
    int wordIndex = 0;
    struct TrieNode *root = malloc(sizeof(struct TrieNode));
    root->data = malloc(sizeof(char));
    for (int i = 0; i < 26; i++) {
      root->children[i] = NULL;
    }

    while(pString[pageIndex] != '\0') {

      // capital letter case
      if(pString[pageIndex] >= 'A' && pString[pageIndex] <= 'Z') {

        char temp = pString[pageIndex];
        temp += ('a' - 'A');
        word[wordIndex] = temp;
        wordIndex++;
      }

      // lower case letter case
      else if(pString[pageIndex] >= 'a' && pString[pageIndex] <= 'z'){

        word[wordIndex] = pString[pageIndex];
        wordIndex++;
      }

      else {

        if(word[0] != '\0') {

          word[wordIndex] = '\0';
          addWordOccurrence(word, wordIndex, root);
          wordIndex = 0;
          word[0] = '\0';
        }
      }
      pageIndex++;
    }
    freeTrieMemory(root);
    return NULL;
  } else {
    return NULL;
  }
}


int addWordOccurrence(const char* word, const int wordLength, struct TrieNode *rootNode)
		       /* TODO: other parameters you need */
{
struct TrieNode * root = rootNode;
// Null case
if(root == NULL) {
  return 0;
}

for(int i = 0;  i < wordLength; i++) {

  int nodeFound = 0;
// checks for preexisting node for corresponding word
  for(int j = 0; j < 26; j++) {
    if (root->children[j] != NULL) {
     if(root->children[j]->data[0] == word[i]){
       root = root->children[j];
       nodeFound = 1;
       }
    }
  }
  // creates node for tree path if not available
    if(!nodeFound){
      int index = word[i] - 'a';
      root->children[index]= malloc(sizeof(struct TrieNode));
      root->children[index]->data = malloc(sizeof(char));
      root->children[index]->data[0] = word[i];
      root->children[index]->count = 0;
      root = root->children[index];
      for(int j = 0; j < 26; j++) {

        root->children[j] = NULL;
      }
  }
}
// adds 1 to word count
printf("\t%s\n", word);
root->count++;
return 1;
}






void printTrieContents(struct TrieNode *root, char* prevData)
{
  // base case

  if (root == NULL) {
    return;
  }

  // prints word if count is not zero and word is not null

  if (root->data != NULL && root->count != 0) {
    char word[100];
    int i = 0;
    while (prevData[i] != '\0' && i < 100) {
      word[i] = prevData[i];
      i++;
    }
    word[i] = root->data[0];
    word[i+1] = '\0';
    printf("%s: %d\n", word, root->count);
  }

  // calls function on children if value not null
  // also gets current data for this tree path

  char data[100];
  int i = 0;
  while (prevData[i] != '\0' && i < 100) {
     data[i] = prevData[i];
    i++;
  }
  if(root->data != NULL) {
    data[i] = root->data[0];
    data[i+1] = '\0';
  } else {
    data[i] = '\0';
  }
  for (i = 0; i < 26; i++) {
    if(root->children[i] != NULL) {
      printTrieContents(root->children[i], data);
    }
  }
}

int freeTrieMemory(struct TrieNode * root)
{
  //structured similar to print trie memory, with recursive call
if (root == NULL) {
        return 0;
    }
    for (int i = 0; i < 26; i++) {
        freeTrieMemory(root->children[i]);
    }
    free(root->data);
    free(root);
    return 1;

}

/* You should not need to modify this function */
int getText(const char* srcAddr, char* buffer, const int bufSize){
  FILE *pipe;
  int bytesRead;

  snprintf(buffer, bufSize, "curl -s \"%s\" | python3 getText.py", srcAddr);

  pipe = popen(buffer, "r");
  if(pipe == NULL){
    fprintf(stderr, "ERROR: could not open the pipe for command %s\n",
	    buffer);
    return 0;
  }

  bytesRead = fread(buffer, sizeof(char), bufSize-1, pipe);
  buffer[bytesRead] = '\0';

  pclose(pipe);

  return bytesRead;
}
