
read -p "Push enter to record voice:" yn

/c/Program\ Files\ \(x86\)/sox-14-4-2/sox.exe -t waveaudio --encoding signed-integer --bits 16 --channels 1 --rate 16000 -d $1&

PID=$!

echo "Please ask a question. Now recording your speech."
read -p "Push enter when finish the question:" yn

kill $PID

echo "Now recognizing speech..."
TRANSCRIPT=$(/c/Program\ Files/LibreOffice\ 5/program/python.exe python/speech_recognizer.py $1)
 
echo "recognition result: " ${TRANSCRIPT}
read -p "Push enter to estimate answer:" yn
ARY=($(java -classpath "lib/lucene-analyzers-3.6.2.jar;lib/lucene-spellchecker-3.6.2.jar;lib/lucene-core-3.6.2.jar;build/classes/java/main;." Matcher  "${TRANSCRIPT}"))

read -p "Push enter to display:" yn
winbin/ForHackathon.exe ${ARY[0]} ${ARY[1]} ${ARY[2]} ${ARY[3]}
