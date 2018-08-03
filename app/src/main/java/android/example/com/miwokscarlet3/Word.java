package android.example.com.miwokscarlet3;

public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId =NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED =-1;
    private int mAudioResourceId ;

    public Word( String miwokTranslation,String defaultTranslation,int audioResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
         mAudioResourceId = audioResourceId ;}

    public Word( String miwokTranslation,String defaultTranslation,int imageResourceId,int audioResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId ;
        mAudioResourceId = audioResourceId ;}

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId (){

        return  mImageResourceId ;
    }

   public int getmAudioResourceId (){
        return mAudioResourceId;
   }

    public boolean hasImage (){
        return mImageResourceId  != NO_IMAGE_PROVIDED ;

     }
}









//   public class Word {
//
//   }
//        private String mMiwokTranslation ;
//        private String mDefaultTranslation ;
//
//
//   public Word(String miwokTranslation ,String defaultTranslation  ){
//       mMiwokTranslation = miwokTranslation ;
//       mDefaultTranslation = defaultTranslation;
//
//}
//
//        public String getMiwokTranslation(){
//            return mMiwokTranslation;
//        }
//
//
//   public String getDefaultTranslation(){
//        return mDefaultTranslation;
//    }
//
//
//
//}
