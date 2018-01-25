setwd('~/IdeaProjects/LaCasaDePapel/')

dataset <- read.csv(file = "blurbs.csv", header = TRUE, sep = "~", quot="")

install.packages('caTools')

library(caTools)
set.seed(123)
split = sample.split(dataset$WORDCOUNT, SplitRatio = 2/5)
training_set = subset(dataset, split == TRUE)
test_set = subset(dataset, split == FALSE)

# Fitting simple linear regression to training set
# the formula here is that the number of characters
# in the source paragraph
regressor = lm(formula = SOURCELENGTH ~ WORDCOUNT,
               data = training_set)

# Predicting the Test set results
y_pred = predict(regressor, newdata = test_set)

# Visualising the Training set results
install.packages('ggplot2')

library(ggplot2)
ggplot() +
  geom_point(aes(x = training_set$WORDCOUNT, y = training_set$SOURCELENGTH),
             colour = 'red') +
  geom_line(aes(x = training_set$WORDCOUNT, y =  predict(regressor, newdata = training_set) ),
            colour = 'blue') +
  ggtitle('Article Total Word Count vs Article Source Length (chars)') +
  xlab('WordCount') +
  ylab('SourceLength')

# regressor is always a trait of the training set
ggplot() +
  geom_point(aes(x = test_set$WORDCOUNT, y = test_set$SOURCELENGTH),
             colour = 'red') +
  geom_line(aes(x = training_set$WORDCOUNT, y =  predict(regressor, newdata = training_set) ),
            colour = 'blue') +
  ggtitle('Article Total Word Count vs Article Source Length (chars)') +
  xlab('WordCount') +
  ylab('SourceLength')
