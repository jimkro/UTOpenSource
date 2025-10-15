//U11316022 洪瑋甯
//作業重點：沿著不同軸看colorcube、分割視窗
//與ex1不同處：第43-75行

#include <stdio.h>
#include <stdlib.h>
#define GL_SILENCE_DEPRECATION
//#include <GL/glui.h>
#include <GLUT/glut.h>

#define WORLD_AXES 1
#define COLORCUBE 2


GLfloat vertices[][3]={
    {-1.0,-1.0,-1.0},{1.0,-1.0,-1.0},
    {1.0,1.0,-1.0},{-1.0,1.0,-1.0},{-1.0,-1.0,1.0},
    {1.0,-1.0,1.0},{1.0,1.0,1.0},{-1.0,1.0,1.0}
};

GLfloat colors[][3]={
    {0.0,0.0,0.0},{1.0,0.0,0.0},
    {1.0,1.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0},
    {1.0,0.0,1.0},{1.0,1.0,1.0},{0.0,1.0,1.0}
};

GLuint window;
GLfloat aspect=1.0;//這樣全域都有值
int width=512;
int height=512;

void display(void){
    width=glutGet(GLUT_WINDOW_WIDTH);
    height=glutGet(GLUT_WINDOW_HEIGHT);
    aspect=(GLfloat)width/(GLfloat)height;
    
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60.0f, aspect, 0.1f, 10.0f);
    
    //從Ｚ軸看
    glViewport(0, 0, width/2, height/2);//放在整體視窗的左上
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(0.0,0.0,5.0,
              0.0,0.0,0.0,
              0.0,1.0,0.0);//y軸在上
    glCallList(WORLD_AXES);
    glCallList(COLORCUBE);
    
    //從Ｙ軸看
    glViewport(0, height/2, width/2, height/2);//左下
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(0.0,5.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0);//z軸在上
    glCallList(WORLD_AXES);
    glCallList(COLORCUBE);
    
    //從Ｘ軸看
    glViewport(width/2, 0, width/2, height/2);//右下
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(5.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0);//y軸在上
    glCallList(WORLD_AXES);
    glCallList(COLORCUBE);
    
    //從45度看
    glViewport(width/2, height/2, width/2, height/2);//右上
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(5.0,5.0,5.0,0.0,0.0,0.0,0.0,1.0,0.0);//y軸在上
    glCallList(WORLD_AXES);
    glCallList(COLORCUBE);
    
    glutSwapBuffers();
}

void My_Reshape(int width,int height){
    aspect=width*1.0f/height;
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glViewport(0, 0, width, height);
    gluPerspective(60.f, aspect, 0.1f, 10.0f);
}



void polygon(int a, int b, int c, int d){
    //用節點定義這個多邊形
    glBegin(GL_POLYGON);
    
    glColor3fv(colors[a]);
    glVertex3fv(vertices[a]);
    glColor3fv(colors[b]);
    glVertex3fv(vertices[b]);
    glColor3fv(colors[c]);
    glVertex3fv(vertices[c]);
    glColor3fv(colors[d]);
    glVertex3fv(vertices[d]);
    glEnd();
}

void init(void){
    
    glEnable(GL_DEPTH_TEST);
    glClearColor(0.2,0.2,0.2,0.0);
    aspect = (GLfloat)width / height;
    
    //定義座標軸
    glNewList(WORLD_AXES,GL_COMPILE);
    glBegin(GL_LINES);
    
    
    // X軸 (紅色)
    glColor3f(1.0,0.0,0.0);
    glVertex3f(0.0,0.0,0.0);
    glVertex3f(aspect*1.5,0.0,0.0);

    // Y軸 (綠色)
    glColor3f(0.0,1.0,0.0);
    glVertex3f(0.0,0.0,0.0);
    glVertex3f(0.0,aspect*1.5,0.0);

    

    // Z軸 (藍色)
    glColor3f(0.0,0.0,1.0);
    glVertex3f(0.0,0.0,0.0);
    glVertex3f(0.0,0.0,aspect*1.5);
    
    
    glEnd();
    glEndList();
    
    //定義ColorCube
    glNewList(COLORCUBE,GL_COMPILE);//color cube
    polygon(0,3,2,1);
    polygon(2,3,7,6);
    polygon(0,4,7,3);
    polygon(1,2,6,5);
    polygon(4,5,6,7);
    polygon(0,1,5,4);
    glEndList();
}


int main(int argc, char* argv[]){
    //設定window
    glutInitDisplayMode(GLUT_RGB|GLUT_DEPTH|GLUT_DOUBLE);
    glutInitWindowSize(width, height);
    glutInitWindowPosition(50, 50);
    glutInit(&argc, argv);
    
    //main window
    window=glutCreateWindow("U11316022");
    init();
    glutDisplayFunc(display);
    glutReshapeFunc(My_Reshape);
    glutPostRedisplay();
    
    glutMainLoop();
    
    return 0;
}
