// For extra fun, before you run the program try to figure out 
// (1) How many processes will be running
// (2) For each process above, how many lines will be printed
// (3) The final value of i
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
    int i = 0;
    printf("Line %d\n", ++i);

    if (fork() == 0) {
        if (fork() == 0) {
            printf("Line %d\n", ++i);
            fork();
        }
        printf("Line %d\n", ++i);
    }
    printf("Line %d\n", ++i);
    return 0;
    
}
