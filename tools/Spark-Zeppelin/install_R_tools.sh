#!/bin/bash -x

#Remove R old version
sudo apt-get remove r-base-core -y
sudo apt-get remove r-base -y
sudo apt-get autoremove -y

codename=$(lsb_release -c -s)  
echo "deb http://ftp.iitm.ac.in/cran/bin/linux/ubuntu $codename/" | sudo tee -a /etc/apt/sources.list > /dev/null  

#Note that instead of http://ftp.iitm.ac.in/cran one must replace it with the geographically closest CRAN mirror. Also, the Ubuntu archives on CRAN are signed with the key of Michael Rutter <marutter@gmail> with key ID E084DAB9. So we type in the following:

sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E084DAB9  
sudo add-apt-repository ppa:marutter/rdev

Followed by what we would normally have done:

sudo apt-get update -y
sudo apt-get upgrade -y
sudo apt-get install -y r-base r-base-dev r-base-core


sudo apt-get install -y libssl-dev
sudo apt-get install -y libcurl4-openssl-dev

#curl package
sudo R -e "install.packages('curl', repos = 'http://cran.us.r-project.org')"

#devtools with
sudo R -e "install.packages('devtools', repos = 'http://cran.us.r-project.org')"

#knitr with 
sudo R -e "install.packages('knitr', repos = 'http://cran.us.r-project.org')"

#Other vizualisation librairies: 
sudo R -e "install.packages(c('devtools','mplot', 'googleVis'), repos = 'http://cran.us.r-project.org'); require(devtools); install_github('ramnathv/rCharts')"

#ggplot2 with 
sudo apt-get install -y r-cran-plyr
sudo apt-get install -y r-cran-reshape2
sudo R -e "install.packages('ggplot2', repos = 'http://cran.us.r-project.org')"

#We recommend you to also install the following optional R libraries for happy data analytics:
#    glmnet
#    pROC
#    data.table
#    caret
#    sqldf
#    wordcloud
sudo R -e "install.packages('glmnet', repos = 'http://cran.us.r-project.org')"
sudo R -e "install.packages('pROC', repos = 'http://cran.us.r-project.org')"
sudo R -e "install.packages('data.table', repos = 'http://cran.us.r-project.org')"
sudo R -e "install.packages('caret', repos = 'http://cran.us.r-project.org')"
sudo R -e "install.packages('sqldf', repos = 'http://cran.us.r-project.org')"
sudo R -e "install.packages('wordcloud', repos = 'http://cran.us.r-project.org')"
sudo R -e "install.packages('evaluate', repos = 'http://cran.us.r-project.org')"

