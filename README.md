All the relevant codes are in the Feat_extract_I3D folder. The rest are irrelevant to extract features.

In Feat_extract_I3D folder, feature_extract.py is the one that does the job, and I recommend you look at the code provided here https://cv.gluon.ai/build/examples_action_recognition/feat_custom.html about how to use this program. makeVideoTXT.java is used to generate the text file, videos.txt needed for executing the program, which is also indicated in the above link. It took me a lot of time and pain to configure the environment, so good luck with that!

python feat_extract.py --data-list videos.txt --model i3d_resnet50_v1_kinetics400 --save-dir ./features --num-segments 10 --new-length 16 --ten-crop should work the best, when num-segments is 10. Because when I used three-crop parameter it gives me assertion error on the width and height. Not sure why but that's how it works out for me.
