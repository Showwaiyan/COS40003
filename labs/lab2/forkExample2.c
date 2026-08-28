// In this example, the parent process creates two child process and then
// terminates without waiting for the child processes
// Notice that the parent process and the two child processes are running concurrently
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
    int status;
  
    printf("Parent: I am parent process\n");
    
    status = fork(); 
    
    if (status == 0) {
        printf("Child 1: I am the first child process of parent process\n");
        for (int i=1; i<=5; i++) {
            printf("Child 1: %d\n", i);
            sleep(1);
        }
        printf("Child 1: Terminating\n");
        return 0;
    }

    printf("Parent: Successfully created child process 1\n");
    status = fork(); 

    if (status == 0) {
        printf("Child 2: I am the second child process of parent process\n");
        for (char j='a'; j<='e'; j++) {
            printf("Child 2: %c\n", j);
            sleep(1);
        }
        printf("Child 2: Terminating\n");
        return 0;
    }

    printf("Parent: Successfully created child process 2\n");
    printf("Parent: Terminating\n");

    return 0;
    
}
