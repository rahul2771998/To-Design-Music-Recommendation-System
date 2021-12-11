# To-Design-Music-Recommendation-System

Problem Definition:
Create an online music recommendation system which suggests songs according to user taste.
Features:
Application has two major things :
1. The songs, which are cataloged in the app’s data store. Songs can be described by attributes such as genre, tempo, singer.
2. The people : Each person has a playlist of songs that they can choose to play from.
Design a system that recommends a set of songs from our music library to the user based on his preferences (matching genre / singer/ tempo) taking into account his current playlist.
Pick a song based on the following order:
1. One which matches with maximum matching attributes.
2. When only one attribute is matching, pick one in the following order : genre >
singer > tempo.
3. To decide priority between two genres\singer\tempo, consider the number of
songs in each category in the user's playlist to decide which song gets more priority. One with a higher number of songs gets high priority. If the number of songs are the same, show in any order.
Show the recommended songs in a sorted order(Most matched one first, least matched in the last)
Requirements:
1. Add a new song to the data store.
 2. Add a new user to the system.
3. Create a playlist for the user
4. Add songs to the user’s playlist
5. Display user’s playlist
6. Recommend songs based on user preferences
7. Extend the system to let users add friends.
a. add_friend(“user1”, “user2”) //user1 and user2 can see each other’s playlist
b. follow_user(“user1”,”user2”) //user1 can see user's playlist but no vice versa
Bonus question:
1. Recommend songs based on the user and his friends playlist.
2. Shuffle play a playlist for user, user should be able to go to last played song.
Other Details:
1. Do not use any database or NoSQL store, use in-memory store for now.
2. Do not create any UI for the application.
3. Code should be demo-able. Write a driver class for demo purpose, which will
execute all the commands at one place in the code and test cases.
4. Code should be extensible. Wherever applicable, use interfaces and contracts
between different methods
5. Work on the expected output first and then add good-to-have features of your
own.
6. Try to read the test cases from a file or console.
Test Cases:
(Test cases are defined for understanding feature requirements only. Please model it appropriately based on your service implementation)
Assuming following songs exist in appstore
Song1 {name:“song1”, singer:“AB”, genre:”Folk”, tempo:60} Song2 {name:“song2”, singer:“DEF”, genre:”Rock”, tempo:70}

Song3 {name:“song3”, singer:“AB”, genre:”Country”, tempo:55} Song4 {name:“song4”, singer:“XYZ”, genre:”Rock”, tempo:60} Song5 {name:“song5”, singer:“XYZ”, genre:”Rock”, tempo:75} Song6 {name:“song6”, singer:“AB”, genre:”Country”, tempo:60} Song7 {name:“song7”, singer:“DEF”, genre:”Indie”, tempo:55}
Here are the sample test cases to run:
● add_song(name:“song8”, singer:“AB”, genre:”Folk”, tempo:60)
● add_user (name:“user1”)
● create_playlist ( “user1”, “playlist1”, {“song1”, “song2”, “song3”})
● add_song_to_playlist (“playlist1”, “song4”)
● show_playlist (“user1”, “playlist1” )
● recommend_songs(“user1”)
○ Song 8 - matching all 3 attributes (singer, genre, tempo - all matching with song1)
○ Song 5 - matching two attributes (genre ‘Rock’ has 2 songs in user playlist hence it is given priority)
○ Song 6 - matching two attributes
○ Song 7 - Single matching attribute
