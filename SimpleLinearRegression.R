setwd('~/IdeaProjects/LaCasaDePapel/')

dataset <- read.csv(file = "blurbs.csv", header = TRUE, sep = "~", quot="")

newdataset <- dataset[-c(35, 40, 152, 190, 343)]
install.packages('caTools')

library(caTools)
set.seed(123)
split = sample.split(dataset$WORDCOUNT, SplitRatio = 2/5)
training_set = subset(dataset, split == TRUE)
test_set = subset(dataset, split == FALSE)

# Fitting simple linear regression to training set
# the formula here is that the number of characters
# in the source paragraph
regressor = lm(formula = SOURCECHARC ~ WORDCOUNT,
               data = training_set)

# Predicting the Test set results
y_pred = predict(regressor, newdata = test_set)