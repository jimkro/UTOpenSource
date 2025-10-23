//開到 double 避免乘除，直接用加減
#include <bits/stdc++.h>
using namespace std;
int main(){

    double point[8]={0};
    while(cin>>point[0]>>point[1]>>point[2]>>point[3]>>point[4]>>point[5]>>point[6]>>point[7]){

        double x=0.0,y=0.0;
        int x2,x3;
        for(int i=0;i<=6;i+=2){ 
            for(int j=i+2;j<=6;j+=2){ 
                if((point[i]==point[j])&&(point[i+1]==point[j+1])){
                    x2=i;
                    x3=j;
                    break;
                }
            }
        }
        
        for(int i=0;i<=6;i+=2){ 
            if(i!=x2&&i!=x3){
                x+=point[i];
                y+=point[i+1];
                
            }
        }
        x-=point[x2];
        y-=point[x2+1];

       
        printf("%.3f %.3f\n",x,y);
    }
    

}
