//Buffer Overflow Code in C
#include <stdio.h>
#include <string.h>

int main(void) {
    char buff[15]; 
    int pass = 0; 

    printf("Enter password: ");
    fgets(buff, sizeof(buff), stdin);
    buff[strcspn(buff, "\n")] = 0;

    if (strlen(buff) >= sizeof(buff) - 1) {
        printf("Buffer overflow detected! Giving root privileges...\n");
        pass = 1;  
    }
    if (strcmp(buff, "thegeekstuff") != 0) {
        printf("Wrong password\n");
    } else {
        printf("Correct password\n");
        pass = 1;
    }

    if (pass) {
        printf("Give root privileges\n");
    }

    return 0;
}
