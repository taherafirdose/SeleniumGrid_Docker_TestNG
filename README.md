# SeleniumGrid_Docker_TestNG

#Setup selenium grid with Docker

https://github.com/SeleniumHQ/docker-selenium

Create a file docker-compose.yaml with required config https://github.com/SeleniumHQ/docker-selenium/blob/trunk/docker-compose-v3.yml

Run below command to run docker-compose.yaml docker-compose up

To check hub and nodes are in running state http://localhost:4444/grid/console

To increase the number of nodes docker-compose up --scale chrome=4

To stop the grid and clean up the created containers, run docker-compose down
