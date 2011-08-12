//
//  User.h
//  Nellodee
//
//  Created by Ada Hopper on 11/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@class SBJsonStreamParser;
@class SBJsonStreamParserAdapter;
@class BasicInfo;
@class About;
@class Categories;

@interface MeService : NSObject {
	NSMutableData *responseData;
    
    BasicInfo *basicInfo;
    About *about;
	Categories *categories;

}
- (BOOL) meService;

@property (nonatomic, retain) NSMutableData *responseData;
@property (nonatomic, retain) BasicInfo * basicInfo;
@property (nonatomic, retain) About *about;
@property (nonatomic, retain) Categories *categories;

@end
