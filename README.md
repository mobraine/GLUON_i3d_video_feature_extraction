All the relevant codes are in the Feat_extract_I3D folder. The rest are irrelevant to extract features.

In Feat_extract_I3D folder, feature_extract.py is the one that does the job, and I recommend you look at the code provided here https://cv.gluon.ai/build/examples_action_recognition/feat_custom.html about how to use this program. makeVideoTXT.java is used to generate the text file, videos.txt needed for executing the program, which is also indicated in the above link. It took me a lot of time and pain to configure the environment, so good luck with that!

python feat_extract.py --data-list videos.txt --model i3d_resnet50_v1_kinetics400 --save-dir ./features --num-segments 10 --new-length 16 --ten-crop should work the best, when num-segments is 10. Because when I used three-crop parameter it gives me assertion error on the width and height. Not sure why but that's how it works out for me.


It turns out I didn't really understand the mechanism behind the feature extraction but I still decide to use this and experiment it with some different parameters. Because I was trying to replicate a paper that use I3D, I have to try to follow closely with their method, which wasn't very clear from the paper. 

After some experiments, I found that segment 64 is the maximum segments the memory can take, and I removed --ten-crop as it is no use to this experiment. So anyways, this could be tested now. Hopefully. And merging npy file to hdf5 using the script by Jaywong Wang I have now get a hdf5 file similar to what I got from the original paper, so I will use the viewer to check if they are indeed similar in structure.


Now the feature that I needed is in def hybrid_forward(self, F, x): line 613 return outs[0], although not sure why outs[0]. After talking to the authors, I changed the feat_dimension to line 527: self.feat_dim = self.block.expansion * 128 * 2 ** (len(self.stage_blocks) - 1), and this should produce 4096 dimension features hopefully. And I load net everytime a new video is loaded so as to adapt its segments to its length.
