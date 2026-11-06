if not exist "AlexsMobs" ( mkdir "AlexsMobs" && git clone https://github.com/Ryorama/AlexsMobs.git "AlexsMobs" && cd "AlexsMobs" & git switch 1.21 ) else if exist "AlexsMobs" ( cd "AlexsMobs" && git pull )
call gradlew build
cd ..
if not exist "AlexsCaves" ( mkdir "AlexsCaves" && git clone https://github.com/Ryorama/AlexsCaves.git "AlexsCaves" && cd "AlexsCaves" & git switch 1.21.1 ) if exist "AlexsCaves" ( cd "AlexsCaves" && git pull )
call gradlew build