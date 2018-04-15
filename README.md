# TestStage1
实训第一阶段资源


administrator@vinzor:~/Desktop$ ./a.out
**1**
**1**
**2**
**4**
**2**
**2**
**4**
administrator@vinzor:~/Desktop$ **3**
**3**
**2**
**3**
**3**

administrator@vinzor:~/Desktop$ ./Test1.o
PARENT: value = 5

administrator@vinzor:~/Desktop$ ./Test.o
b
a
b
administrator@vinzor:~/Desktop$ c
c



#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int main() {
 
   int pid = fork();
   printf("b\n");
   if (pid == 0) {
      int pid1 = fork();
      printf("c\n");
   } else printf("a\n");
   return 0;
}
