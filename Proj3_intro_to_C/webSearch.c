#include "indexPage.h"
#include "crawler.h"

// definitions



// start of main
int main(int argc, char** argv){

  // variable declarations + arguments check

  long seed;

  char startAddr[MAX_ADDR_LENGTH];
  char destAddr[MAX_ADDR_LENGTH];
  printf("Indexing...\n");
  int hopNum, numHops;
  
  struct listNode *pListStart;

  if(argc < 3 || argc > 4){
    fprintf(stderr, "USAGE: %s startAddr numHops [rand seed]", argv[0]);
    return -1;
  }
  
  /* initialization */
  if(argc >= 4){
    seed = atol(argv[3]);
  }
  else{
    seed = time(NULL);
  }

  FILE *fptr;
  fptr = fopen(argv[1], "r");
  char *addr = malloc(sizeof(char) * MAX_ADDR_LENGTH);
  int hops;
  int MAX_LINKS = atoi(argv[2]);

  // gets first address from txt file

  fscanf(fptr, "%s %d", addr, &hops);
  addr[MAX_ADDR_LENGTH - 1] = '\0';

  // initializes list

  pListStart = malloc(sizeof(struct listNode));
  if(pListStart == NULL){
    fprintf(stderr, "ERROR: could not allocate memory\n");
    return -2;
  }
  strncpy(pListStart->addr, addr, MAX_ADDR_LENGTH);
  pListStart->next = NULL;
  printf("%s\n", addr);
  indexPage(addr);
  int linksIndexed = 1;
    

// start of do-while    
  srand(seed);
  do {

    addr[MAX_ADDR_LENGTH - 1] = '\0';
    // breaks loop if MAX_LINKS reached
    if (MAX_LINKS <= linksIndexed) {
      break;
    }

    // gets address and max hop from txt file

    strncpy(startAddr, addr, MAX_ADDR_LENGTH);
    startAddr[MAX_ADDR_LENGTH - 1] = '\0';
    numHops = hops;

    // adds initial link to list if not already there

    if(!contains(pListStart, startAddr)) {
      printf("%s\n", startAddr);
      insertBack(pListStart, startAddr);
      indexPage(startAddr);
      linksIndexed++;
    }

    /* start the crawling */
    for(hopNum=1; hopNum <= numHops; hopNum++){
      
      int res = getLink(startAddr, destAddr, MAX_ADDR_LENGTH);

      // breaks if MAX_LINKS reached
      if (MAX_LINKS <= linksIndexed) {
        break;
      }

      if(!res){
        break;
      }
      if(!contains(pListStart, destAddr)) {
        insertBack(pListStart, destAddr);
        printf("%s\n", destAddr);
        indexPage(destAddr);
        linksIndexed++;
      }
      strncpy(startAddr, destAddr, MAX_ADDR_LENGTH);
    }
  } while(fscanf(fptr, "%s %d", addr, &hops) == 2);

  destroyList(pListStart);
  free(addr);
  fclose(fptr);
  return 0;
}
