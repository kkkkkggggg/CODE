#include <stdio.h>
/*#include <stdlib.h>
#include <windows.h>
#include <mmsystem.h>
#pragma comment(lib,"Winmm.lib")*/

int main()
{
    char emperorName[50];
    printf("请输入当前登基的皇帝名号：");
    scanf("%s",emperorName);//录入字符串时不需要&符号
    printf("皇帝《%s》驾临,有事上奏，无事退朝！\n");
    printf("1、皇帝下旨选妃：\t(增加功能)\n");
    printf("2、翻牌宠幸：\t\t(修改状态功能)\n");
    printf("3、打入冷宫：\t\t(删除功能)\n");
    printf("4、单独召见爱妃去小树林做纯洁的事。\n");
    printf("陛下请选择：");


    /*PlaySound(TEXT("sounds\\HotelCalifornia.wav"),
          NULL,SND_FILENAME | SND_ASYNC | SND_LOOP);
    system("pause");*/
    return 0;
}
