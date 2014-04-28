/* File: D.c
   Author:  Mark Fienup
   Description:  MICS 2014 Programming Contest Problem D - BST Maximum Index
   Determines the max. index of storing a BST an array.
*/

#include <stdlib.h>
#include <stdio.h>

#define PROMPTS 0
#define TRUE 1
#define FALSE 0

struct nodetype {
  int value;
  struct nodetype * left;
  struct nodetype * right;
}; // end nodetype

typedef struct nodetype * nodeptr;


// prototypes
void insertBST(nodeptr bstRoot, int value);
void determineMaxIndex(nodeptr bstRoot, long index, long * maxIndex);
void printInorder(nodeptr bstRoot);


int main() {
  int bstCnt, value, bstSize;
  long maxIndex;
  nodeptr bstRoot;
  
  bstCnt = 0;
  while (TRUE) {
    if (PROMPTS) {
      printf("Enter BST positive values ending in 0: ");
    } // end if
    bstSize = 0;
    bstRoot = NULL; 
    while (TRUE) {
      scanf("%d",&value);
      if (value == 0) {
	break;
      } else {
	if (bstRoot == NULL) {
	  bstRoot = (nodeptr) malloc(sizeof(struct nodetype));
	  bstRoot->left = NULL;
	  bstRoot->right = NULL;
	  bstRoot->value = value;
	} else {
	  insertBST(bstRoot, value);
	} // end if
	bstSize++;
	if (PROMPTS) {
	  printf("%d inserted into BST\n", value);
	} // end if
      } // end if
    } // end while
    if (bstSize == 0) {
      break;
    } // end if
    bstCnt++;
    maxIndex = -1;
    determineMaxIndex(bstRoot, 0, &maxIndex); 
    printf("BST %d has a maximum index of %ld\n", bstCnt, maxIndex);
    if (PROMPTS) {
      printInorder(bstRoot);
      printf("\n");
    } // end if

  } // end while
  
} // end main

void insertBST(nodeptr bstRoot, int newValue) {
  nodeptr temp;

  if (bstRoot->value >  newValue) {
    if (bstRoot->left == NULL) {
      temp = (nodeptr) malloc(sizeof(struct nodetype));
      temp->left = NULL;
      temp->right = NULL;
      temp->value = newValue;
      bstRoot->left = temp;
    } else {
      insertBST(bstRoot->left, newValue);
    } // end if
  } else {
    if (bstRoot->right == NULL) {
      temp = (nodeptr) malloc(sizeof(struct nodetype));
      temp->left = NULL;
      temp->right = NULL;
      temp->value = newValue;
      bstRoot->right = temp;
    } else {
      insertBST(bstRoot->right, newValue);
    } // end if
  } // end if
  
} // end insertBST
  
void printInorder(nodeptr bstRoot) {
  if (bstRoot != NULL) {
    printInorder(bstRoot->left);
    printf("%d ", bstRoot->value);
    printInorder(bstRoot->right);
  } // end if

} // end printInorder
  
void determineMaxIndex(nodeptr bstRoot, long index, long * maxIndex) {

  if (bstRoot != NULL) {
    determineMaxIndex(bstRoot->left, index*2+1, maxIndex);
    if (index > *maxIndex) {
      *maxIndex = index;
    } // end if
    determineMaxIndex(bstRoot->right, index*2+2, maxIndex);
  } // end if

} // end maxIndex
  
  
