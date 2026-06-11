cd .
if not exist "AlexsCaves" 
(
	mkdir "AlexsCaves"
)

cd ./AlexsCaves

for /F %%i in ('dir /b /a "AlexsCaves"') do (
    git clone https://github.com/AlexModGuy/AlexsMobs.git "AlexsMobs"
	git checkout 1.21.1
) else (
	git pull
)
gradlew build