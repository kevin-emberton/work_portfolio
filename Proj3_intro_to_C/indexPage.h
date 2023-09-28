#ifndef INDEXPAGE_H
#define INDEXPAGE_H

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

// data stucture definition

struct TrieNode {
  struct TrieNode *children[26]; // 26 for # of characters in alphabet
  int count;
  char *data;
};      

// function definitions

struct TrieNode *indexPage(const char* url);

int addWordOccurrence(const char* word, const int wordLength, struct TrieNode *rootNode);
  
		       
void printTrieContents(struct TrieNode *root, char* prevData);

int freeTrieMemory(struct TrieNode *root);

int getText(const char* srcAddr, char* buffer, const int bufSize);

#endif 