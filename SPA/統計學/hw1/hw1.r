##multiply

multiply <- function(a, b) {
  ans <- a * b
  return(ans)
}

multiply(238, 621)


##combinat(a,b)

combinat<-function(a,b){
  ans<-factorial(a)/(factorial(b)*factorial(a-b))
  return(ans)
}

combinat(50, 8)
