webSearch: crawler.o indexPage.o webSearch.c
	gcc -g crawler.o indexPage.o webSearch.c -o webSearch -Wall
indexPage.o: indexPage.c indexPage.h
	gcc -g -c indexPage.c -o indexPage.o -Wall
crawler.o: crawler.c crawler.h
	gcc -g -c crawler.c -o crawler.o -Wall
clean :
	rm ./webSearch
	rm ./indexPage.o
	rm ./crawler.o
