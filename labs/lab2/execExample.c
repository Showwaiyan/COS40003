// This example showcases the use of execl() to load an external program to
// the current process
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
    int myPid;
    int forkedPid;
    int waitedPid;
    int exitCode;

    myPid= getpid();
    printf("Parent: My Pid is %d\n", myPid );
    
    forkedPid= fork();
    
    if(forkedPid < 0){
        fprintf(stderr,"fork failed\n");
	return 1;
    }

    // Child execute this part
    if( forkedPid == 0 ){
        sleep(1);
        printf("Child: Child process starts.\n");
        printf("Child: Load and execute an external program\n");
        // load the external program "helloworld" to the current process and run it
	execl("./helloworld", "helloworld", NULL);	// execl("path", "program", argument list)
        printf("Child: This line will not run\n");	// This line will not run as the child process space has been replaced by "helloworld" process
	return 2;
    }
    
    //Parent process continue to execute this
    printf("Parent: Waiting for child process %d\n",forkedPid);
    waitedPid= wait(&exitCode);
    printf("Parent: Child process %d has terminated with exit code %d\n", waitedPid, exitCode >> 8);
    return 0;
}
