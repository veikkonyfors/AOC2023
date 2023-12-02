#
#Usage: cat input | ./day1_puzz2.sh
#
sed \
-e 's/threeightwone/3821/g' -e 's/fiveightwone/5821/g' -e 's/nineightwone/9821/g' -e 's/eightwone/821/g' -e 's/twone/21/g' \
-e 's/nineightwo/982/g' -e 's/fiveightwo/582/g' -e 's/threeightwo/382/g' -e 's/eightwo/82/g'  \
-e 's/nineighthree/983/g' -e 's/fiveighthree/583/g' -e 's/threeighthree/383/g' -e's/eighthree/83/g' \
-e's/nineight/98/g' -e's/oneight/18/g' \
-e 's/one/1/g' -e's/two/2/g' -e's/three/3/g' -e's/four/4/g' -e's/five/5/g' -e's/six/6/g' -e's/seven/7/g' -e's/eight/8/g' -e's/nine/9/g' \
-e 's/[a-zA-Z]//g' -e 's/.*/&\0/' -e 's/^\(.\).*\(.\)$/\1\2/'  \
| paste -s -d+  | bc
