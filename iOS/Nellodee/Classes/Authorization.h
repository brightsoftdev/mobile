//
//  Authorization.h
//  Nellodee
//
//  Created by Mai Giménez on 24/06/11.
//

#import <Foundation/Foundation.h>

@interface Authorization : NSObject {
	NSMutableData *responseData;
}

- (BOOL) formBasedAuth:(NSString*)username:(NSString*)password;

@property (nonatomic, retain) NSMutableData *responseData;

@end
