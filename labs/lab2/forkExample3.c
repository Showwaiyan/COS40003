// This example shows how we can make the parent process to wait for the child process
// to terminate first, before the parent process itself terminates. 
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
    int myPid;
    int status;
    int childReturnValue;
    // getpid() function will return the process ID of the current process
    myPid = getpid();
    printf("Parent: My process ID is %d\n",myPid);
    
    status = fork(); 
    
    if (status > 0) { 
        printf("Parent: Successfully created child process with process ID %d\n", status);
        
        // wait for the child process to terminate
        // waitStatus = child process ID
        // childReturnValue store the termination code return by the child process
        int waitStatus = wait(&childReturnValue);
        // the value of childReturnValue need to be right-shifted by 8 bit (or divide by 256)
        printf("Parent: Received %d from child process\n", childReturnValue >> 8);
        printf("Parent: Terminating\n");
    }    

    else if (status == 0) {
        printf("Child: I am child process %d\n", getpid());
        sleep(1);
        //perform some work
        int someData = 5;
        printf("Child: Terminating and reutrning the value %d\n", someData);
        return someData;
    }
    
    else 
        printf("Failed to create child process\n");
        
    return 0;
    
}
