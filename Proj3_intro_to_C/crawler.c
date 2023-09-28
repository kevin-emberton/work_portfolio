#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "crawler.h"



/*
 * returns 1 if the list starting at pNode contains the address addr,
 *    and returns 0 otherwise
 * */
 int contains(const struct listNode *pNode, const char *addr){

  int equal;
  if (strlen(addr) != strlen(pNode->addr)) {
    return 0;
  }
  int i = strncmp(pNode->addr, addr, strlen(addr));
  if (i == 0) {
    equal = 1;
  } else {
    equal = 0;
  }
  if (equal) {
    return 1;
  } 
  if (pNode->next != NULL) {
    if (contains(pNode->next, addr)) {
     return 1;
    } else {
     return 0;
    }
 }
 return 0;
}
    

/*
 * inserts the address addr as a new listNode at the end of
 *    the list
 */
void insertBack(struct listNode *pNode, const char *addr){

  if (pNode->next != NULL) {
    insertBack(pNode->next, addr);
  } else {
    struct listNode *node = malloc(sizeof(struct listNode));
    strncpy(node->addr, addr, strlen(addr));
    node->addr[strlen(addr)] = '\0';
    node->next = NULL;
    pNode->next = node;
  }
}


/*
 * prints the addresses from pNode to the end of the list,
 *   one on each line
 */
void printAddresses(const struct listNode *pNode){

  printf("%s\n", pNode->addr);

  if (pNode->next != NULL) {
    printAddresses(pNode->next);
  }
}

/*
 * frees the memory associated with this node and all subsequent nodes
 */
void destroyList(struct listNode *pNode){

  if (pNode->next == NULL) {
    free(pNode);
  } else {
    destroyList(pNode->next);
    free(pNode);
  }
}
  


int getLink(const char* srcAddr, char* link, const int maxLinkLength){
  
  const int bufSize = 1000;
  char buffer[bufSize];

  int numLinks = 0;

  FILE *pipe;

  snprintf(buffer, bufSize, "curl -s \"%s\" | python3 getLinks.py", srcAddr);

  pipe = popen(buffer, "r");
  if(pipe == NULL){
    fprintf(stderr, "ERROR: could not open the pipe for command %s\n", buffer);
    return 0;
  }

  fscanf(pipe, "%d\n", &numLinks);

  if(numLinks > 0){
    int linkNum;
    double r = (double)rand() / ((double)RAND_MAX + 1.0);

    for(linkNum=0; linkNum<numLinks; linkNum++){
      fgets(buffer, bufSize, pipe);
      
      if(r < (linkNum + 1.0) / numLinks){
		    break;
      }
    }

    /* copy the address from buffer to link */
    strncpy(link, buffer, maxLinkLength);
    link[maxLinkLength-1] = '\0';
    
    /* get rid of the newline */
    {
      char* pNewline = strchr(link, '\n');
      if(pNewline != NULL){
		    *pNewline = '\0';
      }
    }
  }

  pclose(pipe);

  if(numLinks > 0){
    return 1;
  }
  else{
    return 0;
  }
}
