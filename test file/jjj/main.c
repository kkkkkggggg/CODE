#include <stdio.h>
#include <stdlib.h>

int main()
{
   int y = 1;
   int i = 0;
   while(i < 9)
   {
       y = (y + 1) * 2;
       i++;
   }
   printf("%d\n",y);
   return 0;
}
