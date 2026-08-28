// This example demonstrate how to create a child process from the current(parent) process
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
    int myPid;
    int status;
  
    // getpid() function will return the process ID of the current process
    myPid = getpid();
    printf("Parent: My process ID is %d\n",myPid);
    
    // fork() function creates a child process which is a clone of the parent process
    status = fork(); // fork() function return an integer value (status)
    
    // if fork() was successful, it returns the child process ID to the parent process
    // (which is a positive integer); it also returns 0 to the newly created child process
    // if fork() failed due to not enough resources to create child process, it returns 
    // a negative integer to the parent process
    if (status > 0) { 
        printf("Parent: Successfully created child process with process ID %d\n", status);
        sleep(1);
        printf("Parent: Terminating\n");
    }    

    else if (status == 0) {
        printf("Child: I am child process %d\n", getpid());
        sleep(1);
        printf("Child: Terminating\n");
    }
    
    else 
        printf("Failed to create child process\n");
    
    return 0;
    
}
