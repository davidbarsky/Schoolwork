/*************************************************************************************/
/*COSCI 21a Assignment P0 Sample Solution.                                           */
/*J. Storer.                                                                         */
/*   Compile by doing: gcc -ansi -Wall -o Sort Sort.c                                */
/*   Run by doing: ./Sort                                                            */
/*************************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#define MaxString 80

/*************************************************************************************/
/*Data Input                                                                         */
/*************************************************************************************/

/*Read next input line into string s and return 1 if it is non-empty.*/
int READLINE(char s[]) {
    fgets(s,MaxString,stdin);
    return( (s[0]!='\n') ? 1 : 0 );
}

/*************************************************************************************/
/*List Definition And Operations                                                     */
/*************************************************************************************/

/*Vertex data type.*/
typedef struct vbody {
   struct vbody *NEXT;
   int DATA;
} *TypeVertex;

/*Allocate memory for a new vertex.*/
TypeVertex NEWVERTEX() {
    TypeVertex p = (TypeVertex) malloc(sizeof(struct vbody));
    if (p==NULL) {
        printf("Malloc for a new vertex failed."); 
        exit(1);
    }
    return p;
}
/*List L is a global variable that is just a pointer to its first item.*/
TypeVertex L;
/*Insert into L a new vertex with data n after vertex v.*/
/*Giving the argument v=NULL means insert at the beginning of the list.*/

void INSERT_TO_L(int n, TypeVertex v) {
    TypeVertex w = NEWVERTEX();
    w->DATA = n;
    if (v==NULL) {
        w->NEXT = L;
        L = w;
   } else {
       w->NEXT = v->NEXT;
       v->NEXT = w;
   }
}

/*Define shorthand notation for NEXT and DATA.*/
#define NEXT(v) (v->NEXT)
#define DATA(v) (v->DATA)

/*************************************************************************************/
/*START OF PROGRAM                                                                   */
/*************************************************************************************/
int main() {
    char s[MaxString];
    int n;
    TypeVertex v, w;
    printf("\nHello.\n");

    do {
        printf("\nINPUT LIST (enter one integer per line; return to finish):\n");
        L = NULL;
        while (READLINE(s)) {
            sscanf(s,"%d",&n);
            v = NULL;
            for (w=L; ( (w!=NULL) && (DATA(w)<n) ); w=NEXT(w)) v=w;
            INSERT_TO_L(n,v);
        }

        printf("SORTED LIST:\n");
        if (L==NULL) {
            printf("List is empty.\n");  
        } else {
            for (v=L; v!=NULL; v=NEXT(v)) printf("%d\n",DATA(v));
        }
        
        printf("\nDo it again? ");
        READLINE(s);
    } while ( (s[0]=='y') || (s[0]=='Y') );
    
    printf("\nGoodbye.\n\n");
    return 0;
}