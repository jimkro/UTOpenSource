##################################################################
###### Author: Tzu-Ping Liu                                  #####
###### Title: R_w5                                           #####
###### Purpose: basic R and descriptive statistics           #####
###### Required: NA                                          #####
###### Date: 10/25/2021                                      #####
###### Filename: R_w5.R                                      #####
###### Output: N/A                                           #####
##################################################################


## Let's try to load the data now
## Unless the "thing" is a number 
## You have to name the "thing" and tell R the names of the "thing"
## And then R can recognize it
## It means we have to name the data e load and tell R too
## You can name it (them) in the way you want
## To read the "Stata" data (.dta), we use the code "read.data()"
## There are other types of data formats
## For example, the ".csv" format
## To read the "csv" file, we use the code "read.csv()"
## For the other example, the ".txt" format
## To read the "txt" file, we use the code "read.table()"



## Recall that, what type of data format we have for this problem set?
## By its format, whuch code should we use?

approval <- read.csv("/home/jimkro/Documents/GitHub/UTOpenSource/SPA/統計學/hw1/bushapproval.csv") # 讀新的資料

## The stuff "<-" means "="
## It means we assign everything on the right hand side
## to the thing on the left hand side
## In other words, we name to the whole thing on the right hand side as "approval"
## And the word on the left hand side is the name


## Now we load the data in R
## Let's take a look at the data by using the code "View()"
## This is for Window's R users
View(approval)


## Let's Check the data
colnames(approval)
nrow(approval)
dim(approval)

## Attaching the data set for R to perform tasks upon
## Why do we need to attach the data?
## It can help you save some time

## From the data set, we know there is a variable called "bush"
## Let's get the mean of "bush"

mean(bush)

## Does it work? Why?
## You have to be very detailed to R
## You have to tell R that the variable "bush" is from the data "approval"
## Let's get the mean of the variable "bush" from the data "approval" again

mean(approval$bush)

## The "approval$bush" is telling R the "relationship" described above


## Now let's attach the data

attach(approval)

#####################################################################################

## And let's try just "mean(bush)"

mean(bush)

## Does it work? Why?
## Let's try other required things

var(bush)
sd(bush)
median(bush)
IQR(bush)
summary(bush)

## We will learn the meanings of the things about what we just did
## For now, I just give you the names

## var = variance
## sd = standard deviation
## median = median
## IQR = interquarter range
## summary is to get the summary statistic


#####################################################################################

## Let's do the plots now
## Creating a histogram of Bush¡¦s approval rating for his Presidency
## We use the code "hist()"

hist(bush, xlab="Gallup Approval", main="Bush Approval Ratings, 2001-2009",
     col="red")
abline(h=0, col="gray60")
box()

## In "hist()", first we must tell which variable we wanna conduct
## "xlab" means the label (name) of x-axis, same for "ylab"
## "main" means the name of this plot, col means color
## The code "abline()" means we add a line on the plot
## "abline()"---"a" means the intercept "b" means the slope
## In "abline()" here, "h=0" means we wanna draw a "horizontal" line at "y=0"
## Again, "col" here refers to the color of the line, we use "gray60"
## You can try some other colors
## Can you draw a vertical line by yourself?
## "box()" means we put a frame on the plot

#####################################################################################

## Creating a box plot of Bush¡¦s approval rating for his Presidency
## We use the code "boxplot()"

boxplot(bush, ylab="Bush Approval Rating", 
        main="Bush Presidency Approval Ratings")
box()

## Do you know the meaning of each part inside "boxplot()"?

#####################################################################################

## Let's do some more codes now
## "c()" means we Combine different numbers together by their order

c(1,2,3)
c(99,100,29)

## the code "rep()" can help us to generate a series of numbers 
## which have the same value

rep(1,3)

## In "rep()", the left hand side of "," is the value we wanna REPeat
## The right hand side of "," is how many time we wanna REPeat
## The code above means we wanna REPeat "1" for "3" times

## Separating out Bush¡¦s first term (Jan. 2001-Jan. 2005) and second term
## (Jan.2005-Jan. 2009.) This code creates a new variable. The notation
## "$" attaches the newvariable, called "bushsecond" to the data set. This
## code tells R to REPeat (hence "rep") through the first 155 lines of the data
## set and score the variable "bushsecond" as a 0 and then REPeat through the
## remaining 128 lines and score the variable a 1. This way, I can identify
## Bush¡¦s first Presidential term from his second Presidential Term

approval$bushsecond<-c(rep(0,155), rep(1,128))
boxplot(approval$bush~approval$bushsecond, axes=FALSE,
ylab="Bush Approval Rating", main="Bush Approval Rating by Term")
axis(1, at=c(1,2), labels=c("First Term", "Second Term"))
axis(2)
box()

## Remeber we have talked about "$" above?
## The first line says 
## we create a new thing "bushsecond" in the data "approval"
## and we also assign values to this new thing (variable) "bushsecond"
## What values do we assign to "bushsecond" in "approval"?
## The first 155 values are "0" and the rest of 128 values are "1"
## How do we know that?
## "rep(0,155)" means we REPeat "0" 155 times
## "rep(1,128)" means we REPeat "1" 128 times
## Don't forget "c()" there---we Combine things
## "c(rep(0,155), rep(1,128))" means we combine 155 "0"s and 128 "1"s
## Question: why can't we just use "bushsecond"? 
## (We use "approval$bushsecond" here)
## In "boxplot()", "approval$bush~approval$bushsecond" means
## We wanna draw "bush" in different groups
## The groups are divided by "bushsecond"
## Let's just run the first line again
## "axis()" means you wanna add or change something on the axis of the plot
## The first term in "axis()" indicate which axis--"1" means x-axis "2" means y axis
## In "axis(1, at=c(1,2), labels=c("First Term", "Second Term"))"
## "at=c(1,2)" tells R where we wanna add or change
## so it means we wanna add things at x=1 and x=2
## I'll let you explain "labels"
## See that "c()" can combine things more than numbers
## "axis(2)" means for y-axis here, we just add its real values 

#####################################################################################

## Creating a box plot for each year of Bush¡¦s Presidency (2001-2009). Note
## that the 2009 plot will be meaningless because there was only a single survey
## taken before he left office in Jan. 2009

boxplot(bush~year, ylab="Bush Approval Rating", 
        main="Bush Approval Rating by Year")
box()

## Try explain the code here by yourself

#####################################################################################

## Creating a time-series plot for each period in which the American public
## was surveyed about its opinion regarding President Bush. I will build this
## plot up sequentially so you can see what changes to the R code does to the
## plot image.

## We use "plot()" to creat "scatter-plot"

## Ugly---I think he means you don't wanna give us this type of plot

plot(bush ~ obs)

## Similar to "boxplot()"
## We draw the value of "bush" on the y-axis based on the value of "obs" on x-axis

## Bad---He means don't do this

plot(bush~obs, ylab="Bush Approval Rating", main="Time-Series Plot of Bush
     Approval Rating", pch=1000, type="l")

## "pch" means what type of symble we wanna use for each dot on the plot
## "type" means what type of line we wanna use to connect the dots


## Better---He means B to B+

plot(bush~obs, ylab="Bush Approval Rating", main="Time-Series Plot of Bush
     Approval Rating", pch=20, type="l", xaxt="n", 
     xlab="Semi-Monthly Gallup Surveys, 2001-2009")
axis(1, at=c(1, 32, 77, 118, 153, 196, 226, 253, 283), labels=c("2001",
     "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009"), 
     cex.axis=.65, las=1)

## "xaxt" we take out the x-axis out of the code "plot()"
## because we wanna design our own x-axis
## "cex" meansindicating the amount by which plotting text and symbols should be scaled relative to the default
## "cex.axis" means magnification of axis annotation relative to cex
## "las" labels are parallel (=0) or perpendicular(=2) to axis

## Beautiful---an A

plot(bush~obs, ylab="Bush Approval Rating", main="Time-Series Plot of Bush
     Approval Rating", pch=20, type="l", xaxt="n", 
     xlab="Semi-Monthly Gallup Surveys, 2001-2009",
     ylim=c(0,100))
axis(1, at=c(1, 32, 77, 118, 153, 196, 226, 253, 283), labels=c("2001",
     "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009"), 
     cex.axis=.65, las=3)

## "ylim"---we set the floor and the ceiling for values on y-axis


## We can actually use the code to save the beautiful plot

## Saving as "pdf" file

pdf("the name of the file you wanna have")
plot(bush~obs, ylab="Bush Approval Rating", main="Time-Series Plot of Bush
     Approval Rating", pch=20, type="l", xaxt="n", 
     xlab="Semi-Monthly Gallup Surveys, 2001-2009",
     ylim=c(0,100))
axis(1, at=c(1, 32, 77, 118, 153, 196, 226, 253, 283), labels=c("2001",
     "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009"), 
     cex.axis=.65, las=3)
dev.off()

## Or saving as "jpg" file

jpeg("the name of the file you wanna have")
plot(bush~obs, ylab="Bush Approval Rating", main="Time-Series Plot of Bush
     Approval Rating", pch=20, type="l", xaxt="n", 
     xlab="Semi-Monthly Gallup Surveys, 2001-2009",
     ylim=c(0,100))
axis(1, at=c(1, 32, 77, 118, 153, 196, 226, 253, 283), labels=c("2001",
     "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009"), 
     cex.axis=.65, las=3)
dev.off()





































