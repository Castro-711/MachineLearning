dataset <- read.csv(file = "blurbs.csv", header = TRUE, sep = "~", quot="")

install.packages('caTools')

library(caTools)
set.seed(123)
split = sample.split(dataset$WORDCOUNT, SplitRatio = 1/10)
training_set = subset(dataset, split = TRUE)
test_set = subset(dataset, split = FALSE)