#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct COMMAND_BLOCK{
    char com[5];
    int num;
    struct COMMAND_BLOCK *next;
};

struct COMMAND_BLOCK *head = malloc(sizeof(struct COMMAND_BLOCK));

void input(){
    bool breaker = false;

    while(!breaker){
        breaker = true;
    }
}
int main(void){
    input();
    return 0;
}